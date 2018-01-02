package com.lwjnicole.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import com.lwjnicole.vo.CaseVo;

/**
 *
 * <b>类名：</b>CreateFileUtils.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2018年1月3日 上午12:11:58
 * @Description java文件测试类生成工具
 */
public class CreateFileUtils {
	public static void CreateJavaFile(CaseVo caseVo){
				
		String filePath = System.getProperty("user.dir") + "\\src\\com\\lwjnicole\\test";
		 File file = new File(filePath+"\\apiTest.java");
		try{
			if(!file.exists()){
				 file.createNewFile();
			 }
			FileWriter fw = new FileWriter(file);
			fw.write(CaseFactory.getCase(caseVo));//自动生成测试类
			fw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		 	
		//编译
		String dest = System.getProperty("user.dir") + "\\build\\classes"; 
		List<String> options = new ArrayList<String>();  	
       options.add("-d");  
       options.add(dest); 
		JavaCompiler javac=ToolProvider.getSystemJavaCompiler();  
       StandardJavaFileManager javafile=javac.getStandardFileManager(null, null, null);  
       String fileName= filePath+"\\apiTest.java";  
       Iterable units=javafile.getJavaFileObjects(fileName);  
       CompilationTask t=javac.getTask(null, javafile, null, options, null, units);  
       t.call();  
       try {
       	javafile.close();  
       } catch (Exception e) {
       	e.printStackTrace();
       }  
	}
}
