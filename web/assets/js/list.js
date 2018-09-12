											function change()  
											{  
											   var x = document.getElementById("first");  
											   var y = document.getElementById("second");  
											   y.options.length = 0; // 清除second下拉框的所有内容  
											   if(x.selectedIndex == 0)
											   {
											   	y.options.add(new Option("请选择","0"));
											   }
											   if(x.selectedIndex == 1)  
											   {  
											        y.options.add(new Option("计算机类", "0"));  
											        y.options.add(new Option("计算机科学与技术（计算金融）", "1"));  
											        y.options.add(new Option("物联网工程", "2"));  
											   }  
											  
											   if(x.selectedIndex == 2)  
											   {  
											        y.options.add(new Option("俄语", "0"));
											        y.options.add(new Option("法语", "1"));
											        y.options.add(new Option("日语", "2"));
											        y.options.add(new Option("西班牙语", "3"));
											        y.options.add(new Option("英语", "4"));
											   }  
											   if(x.selectedIndex == 3)  
											   {  
											        y.options.add(new Option("美术学", "0"));
											        y.options.add(new Option("绘画", "1"));
											        y.options.add(new Option("视觉传达设计", "2"));
											        y.options.add(new Option("环境设计", "3"));
											        y.options.add(new Option("动画", "4"));
											        y.options.add(new Option("音乐学", "5"));
											        y.options.add(new Option("广播电视编导", "6"));
											        y.options.add(new Option("表演", "7"));
											        y.options.add(new Option("舞蹈表演", "8"));
											   }  
											   if(x.selectedIndex == 4)  
											   {  
											        y.options.add(new Option("城乡规划", "0"));  
											        y.options.add(new Option("工程力学", "1")); 
											        y.options.add(new Option("环境工程", "2"));
											        y.options.add(new Option("环境科学", "3"));
											        y.options.add(new Option("建筑学", "4"));
											        y.options.add(new Option("风景园林", "5"));
											        y.options.add(new Option("土木类", "6"));
											   } 
											   if(x.selectedIndex == 5)  
											   {  
											        y.options.add(new Option("临床药学", "0")); 
											        y.options.add(new Option("药学", "1")); 
													y.options.add(new Option("口腔医学", "0")); 
											        y.options.add(new Option("临床医学（口腔医学）", "1"));
											        y.options.add(new Option("口腔医学技术", "2"));
											   }  
											  
											  
											}  
											
	function skip()
											{
											    window.location.href="Manager_DataCheckDeaper.html";
											}
