package com.wordladder;


public class Wordladder {
	//private static Logger logger = Logger.getLogger(Wordladder.class);
	  private String dict;
	   private String word1;
	   private String word2;
	   public void setDict(String dict) {
		      this.dict = dict;
		   }
	   public String getDict() {
		   //logger.debug(dict);
		      return dict;
		   }
	   
	   public void setWord1(String word1) {
		      this.word1 = word1;
		   }
	   public String getWord1() {
		  // logger.debug(word1);
		      return word1;
		   }
	   public void setWord2(String word2) {
		      this.word2 = word2;
		   }
	   public String getWord2() {
		 //  logger.debug(word2);
		      return word2;
		   }
	   public String getRes() {
		   App ap=new App(this.dict,this.word1,this.word2);
		   return ap.getRes();
	   }
	   
	   
	   
}
