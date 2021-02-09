import java.util.ArrayList;

public class StringCalculator {
	
	public int add(String numbers)
	{
		int sum=0;
		try
		{
		if(numbers.length()==0 || numbers.equals(""))
			return 0;
		
		if(numbers.length()==1)
			return Integer.parseInt(numbers);
		
		int count_neg=0;
		ArrayList<String> neg_list=new ArrayList<>();
		
		for(int i=0;i<numbers.length();i++)
		{
			if(numbers.charAt(i)=='-')
			{
				count_neg++;
				neg_list.add(numbers.charAt(i)+""+numbers.charAt(i+1));
			}

		}
		if(count_neg==1)
		{
			throw new NegativeNumberException("Negatives Not Allowed");
		}
		
		if(count_neg>1)
		{
			System.out.println("Multiple Negative Number found : "+neg_list.toString());
			throw new NegativeNumberException("Negatives Not Allowed");
		}
		
		
		numbers=numbers.replaceAll("\n//%[]()*"," ");
		String nums[];
		if(numbers.contains(","))
		{
			numbers=numbers.trim();
			nums=numbers.split(",");
		}
		else if(numbers.contains(";"))
		{
			numbers=numbers.trim();
			nums=numbers.split(";");
		}
		else
		{
			numbers=numbers.trim();
			nums=numbers.split("\\s+");
		}
		
		for(int i=0;i<nums.length;i++)
		{
			if(Integer.parseInt(nums[i])<1000)
			sum+=Integer.parseInt(nums[i]);
		}
		}
		
		catch(NegativeNumberException e)
		{
			System.out.println(e.getMessage());
		}
		
		return sum;
		
	}

}

class NegativeNumberException extends Exception
{
	public NegativeNumberException(String message)
	{
		super(message);
	}
}
