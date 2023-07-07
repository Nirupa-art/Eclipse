import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Streams {
	
	@Test
	public void example() {
		List<String> names=new ArrayList<String>();
		names.add("Rupa");
		names.add("satya");
		names.add("satyansh");
		int count=0;
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
			if(names.get(i).startsWith("s")) {
				count++;}
		}
		System.out.println(count);
	}
	
	@Test(enabled=false)
	public void stream() {
		List<String> names=new ArrayList<String>();
		names.add("Rupa");
		names.add("satya");
		names.add("satyansh");
		int count=0;
		Long c=names.stream().filter(s->s.startsWith("s")).count();
		System.out.println(c);
		
		
		//or
		
		Long d = Stream.of("Rupa","Prasad","Satyansh","Nitya").filter(s->
		{
			s.startsWith("S");
			return true;
			
		}).count();
		System.out.println(d);
		
		//or
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));//to limit the output to 1
		
		
		//maps
		//names with r convert to uppercase
		
		Stream.of("Rupa","Prasad","Satyansh","Nitya").filter(s->s.startsWith("R")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//covert names starting with N to upper case and sort them out and print.
		
		List<String> newnames=Arrays.asList("Amma","Nanna","Haritha","Prasad","Phani","Rupa");
		newnames.stream().filter(s->s.startsWith("P")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//MErging 2 different streams
		
		Stream<String> newstream=Stream.concat(names.stream(), newnames.stream());
		newstream.sorted().forEach(s->System.out.println(s));
		
		//anymatch
		
		boolean flag = newstream.anyMatch(s->s.equalsIgnoreCase("Prasad"));
		System.out.println(flag);
		
		
		
		
		
		}
	
	@Test
	public void streamcollectore() {
		List<String> ls=Stream.of("CA","SanDeigo","Menifee","Riverside","LA","Murrieta").filter(s->s.endsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(ls.get(1));
		
		
		//To print uniques values
		List<Integer> values=Arrays.asList(3,4,52,7,8,3,5);
		//values.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> li1=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li1.get(5));
		
	}}

