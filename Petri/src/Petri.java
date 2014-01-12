import java.util.Arrays;



public class Petri {
	
	
	public static void main(String[] args){
		int[] start = {1,0,1,1,1};
		
		petri_step_calc(start, "");
	}
	public static void petri_step_calc(int[] p, String step){
		//t1
		int[] p1 = Arrays.copyOf(p,5);
		int[] p2= Arrays.copyOf(p,5);
		int[] p3 = Arrays.copyOf(p,5);
		int[] p4 = Arrays.copyOf(p,5);
		int countChild=0;
		if (p1[0]>0){
			p1[1]=p[1]+1;
			p1[2]=p[2]+1;
			p1[3]=p[3]+2;
			countChild++;
			System.out.println("t1:");
			System.out.println(Arrays.toString(p1).replaceAll(" ", ""));
		}
		//t2
		if ( (p[1]>0) && (p[2]>0) && (p[3]>0) ){
			p2[2]=p[2]-1;
			p2[3]=p[3]-1;	
			countChild++;
			System.out.println("t2:");
			System.out.println(Arrays.toString(p2).replaceAll(" ", ""));
		}
		//t3
		if ((p[3]>1)){
			p3[3]=p[3]-2;
			p3[4]=p[4]+1;
			countChild++;
			System.out.println("t3:");
			System.out.println(Arrays.toString(p3).replaceAll(" ", ""));
		}
		//t4
		if ((p[4]>0)){
			p4[2]=p[2]+1;
			p4[3]=p[3]+1;
			countChild++;
			System.out.println("t4:");
			System.out.println(Arrays.toString(p4).replaceAll(" ", ""));
		}
	}
	

}

