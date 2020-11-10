/** 
 * <pre>项目名称:ssm-demo-wdd 
 * 文件名称:PoiUtils.java 
 * 包名:com.jk.wdd.utils 
 * 创建日期:2020年7月22日上午10:33:23 
 * Copyright (c) 2020, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/** 
 * <pre>项目名称：ssm-demo-wdd    
 * 类名称：PoiUtils    
 * 类描述：    
 * 创建人：wdd   
 * 创建时间：2020年7月22日 上午10:33:23    
 * 修改人：wdd 
 * 修改时间：2020年7月22日 上午10:33:23    
 * 修改备注：       
 * @version </pre>    
 */
public class PoiUtils {
	
	/**
	 * <pre>importExcel(poi导入excel)   
	 * 创建人：wdd    
	 * 创建时间：2020年7月22日 下午3:06:21    
	 * 修改人：wdd     
	 * 修改时间：2020年7月22日 下午3:06:21    
	 * 修改备注： 
	 * @param filename 导入的文件
	 * @param fieldarr 导入的对象的属性名
	 * @param cc 需要的对象：用户对象、学生对象
	 * @return
	 * @throws IOException</pre>
	 */
	public static List importExcel(MultipartFile filename,String[] fieldarr,Class cc){
		//1、创建导入的文件
		InputStream input;
		List list = null;
		try {
			input = filename.getInputStream();
			//2、创建excel的工作表
			//获取上传的文件名称
			String oldname = filename.getOriginalFilename();
			//判断是03还是07
			Workbook book = null;
			if(oldname.endsWith(".xls")){//03   以...结尾
				book = new HSSFWorkbook(input);
			}else{//07
				book = new XSSFWorkbook(input);
			}	
			//3、获取sheet页
			Sheet sheet = book.getSheetAt(0);
			//4、获取表格的值
			//获取行数
			int rownum = sheet.getLastRowNum();//2
			
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < rownum ; i++) {
				Row row = sheet.getRow(i+1);
				
				JSONObject jsonObject = new JSONObject();
				//{"id","name".....}
				for (int j = 0; j < fieldarr.length; j++) {
					//String value = row.getCell(j).getStringCellValue();
					Cell cell = row.getCell(j);
					if(cell!=null){
						//调用方法获取单元格的值
						String value = getMyCellType(cell);
						//把值存放josn对象
						jsonObject.put(fieldarr[j], value);
					}
				}
				jsonArray.add(jsonObject);
			}		
			
			//把json数组转换成list集合
			list = JSONArray.parseArray(jsonArray.toJSONString(), cc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * <pre>exportExcel(poi导出excel)  
	 * 1、sheet名称  2、表头   3、list：导出的数据  4、文件名称  5、json的参数 
	 * 创建人：wdd    
	 * 创建时间：2020年7月22日 下午2:27:18    
	 * 修改人：wdd     
	 * 修改时间：2020年7月22日 下午2:27:18    
	 * 修改备注： 
	 * @param response 响应对象
	 * @param dataAraay list集合转换成json数组
	 * @param map   key：标题     value ：json的参数 
	 * @param sheetName  sheet页的名称
	 * @param excelname 导出的文件名称</pre>
	 */
    public static void exportExcel(HttpServletResponse response, JSONArray dataAraay, Map<String,String> map, String sheetName,String excelname) {
        //创建表格
    	XSSFWorkbook book=new XSSFWorkbook();
    	//创建sheet页
        XSSFSheet sheet=book.createSheet(sheetName);
        
        //创建表头
        Iterator<String> iterator = map.keySet().iterator();
        Row row = sheet.createRow(0);
        int i = 0;
        List<String> list = new ArrayList<String>();	
        //{"id","name","other","sexname","cityname"}
        while (iterator.hasNext()){//判断是否有下一个值
            String key = iterator.next();//获取下一个值
            Cell cell = row.createCell(i);
            //给表头的单元格赋值
            cell.setCellValue(key);
            list.add(map.get(key));
            i++;
        }
        
        
        //写入数据
        for(int j = 0; j < dataAraay.size(); j++){
        	//把用户对象转换成json对象
            JSONObject jsonObject = dataAraay.getJSONObject(j);
            Row dataRow = sheet.createRow(j+1);//创建行
            // //{"id","name","other","sexname","cityname"}
            for(int k = 0; k < list.size(); k++){
            	String field = list.get(k);//id、name
            	String value = jsonObject.getString(field);//1、张三
                dataRow.createCell(k).setCellValue(value);
            }
        }
        
        
        try {
        	//生成excel文件
        	//OutputStream out = new FileOutputStream("F:/2003.xlsx");
        	//设置响应为文件下载：header设置
			response.setHeader("content-disposition", "attchment;filename="+URLEncoder.encode(excelname,"utf-8"));
			
			ServletOutputStream out = response.getOutputStream();
			book.write(out);
			
			//7、关闭流
			out.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }	
    
    //获得cell的值
    private static String getMyCellType(Cell cell){
        String value = "";
        switch (cell.getCellType()) {//获取单元格的类型
            case Cell.CELL_TYPE_NUMERIC: // 数字或日期 0
                //如果为时间格式的内容
                if (DateUtil.isCellDateFormatted(cell)) {//日期
                    //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    value=sdf.format(cell.getDateCellValue()).toString();
                    break;
                } else {//数值
                    value = new DecimalFormat("0").format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串 1
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean 4
                value = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式 2
                value = cell.getCellFormula() + "";
                break;
            case Cell.CELL_TYPE_BLANK: // 空值 3
                value = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障 5
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }
        return value;
    }   
}
