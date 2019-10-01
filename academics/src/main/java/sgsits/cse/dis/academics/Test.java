package sgsits.cse.dis.academics;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		int adyear = 2016;
		Calendar cal = Calendar.getInstance();
		int curYear = cal.get(Calendar.YEAR);
		int curMonth = (cal.get(Calendar.MONTH))+1;
		
		int syear = curYear - adyear;
		
		String sem = null,year = null,session = null;
		
		if(curMonth>=1&&curMonth<=6)
		{
			sem = "B";
			session = (curYear-1) + "-" + curYear;
			if(syear==1)
				year = "I";
			if(syear==2)
				year = "II";
			if(syear==3)
				year = "III";
			if(syear==4)
				year = "IV";			
		}
		else if(curMonth>=7&&curMonth<=12)
		{
			sem = "A";
			session = curYear + "-" + (curYear+1);
			if(syear==0)
				year = "I";
			if(syear==1)
				year = "II";
			if(syear==2)
				year = "III";
			if(syear==3)
				year = "IV";
		}
	}
}
