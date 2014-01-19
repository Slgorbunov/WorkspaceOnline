/**
 *
 * @author gorbunov
 * @date 20.01.2014
 */
package lab6;
import java.util.ArrayList;

public class lab6 {

	public static int Column=2;
	public static int Row=2;
	
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<element[][]> MatrixList = new ArrayList();
        //Ниже вводится начальная матрицу из задания
        //false - там где *
        element[][] initial =  {
            {new element(true), new element(true), new element(false)},
            {new element(false), new element(false), new element(true)},
            {new element(false), new element(true), new element(true)}
        };
        for  (int i = 0; i <= 2; i++){
        	for (int j = 0; j <= 2; j++){
	             System.out.print(initial[i][j].x0+" ("+initial[i][j].x12+", "+initial[i][j].x21+", "+initial[i][j].x23+")");
        	}
        	System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------");

        MatrixList.add(initial);
        int size = MatrixList.size();
        do{
        	size = MatrixList.size();
        	MatrixList.add(setNewMatr(MatrixList.get(size-1)));
        }
        while ((size<=7) || (MatrixList.get(size-2).equals(MatrixList.get(size-1))));
        
    }
    public static element[][] setNewMatr(element[][] one){
        //element[][] newMatr = one.clone();
    	//element[][] newMatr = new  element[3][3];
        
        element[][] newMatr =  {
        		{new element(true), new element(true), new element(false)},
                {new element(false), new element(false), new element(true)},
                {new element(false), new element(true), new element(true)}
            };
        
        int i=0;
        int j=0;
        boolean Jplus1=false, Iplus1=false, Jmin1=false, Imin1=false;
         
        for ( i = 0; i <= Row; i++){
			 for (j = 0;j <= Column; j++){
				 
				 	if (i+1 > Column){
				 		Iplus1=false;
			 		}
				 	else{ 
				 		Iplus1=one[i+1][j].x12;
				 	};
				 	
				 	if (i-1<0){
				 		Imin1=false;
				 	}
				 	else {
				 		Imin1=one[i-1][j].x23;
				 	};
				 	
				 	if (j-1<0){
				 		Jmin1=false;
				 	}
				 	else {
				 		Jmin1=one[i][j-1].x21;
				 	};
				 	
			 		newMatr[i][j].x12=one[i][j].x0|Iplus1;
		            newMatr[i][j].x21=Jmin1|(one[i][j].x0&Iplus1);
		            
		            newMatr[i][j].x23=(one[i][j].x0|Imin1)&(!(Iplus1));
		     }
        }
        for  (i = 0; i <= 2; i++){
        	for (j = 0; j <= 2; j++){
	             System.out.print(newMatr[i][j].x0+" ("+newMatr[i][j].x12+", "+newMatr[i][j].x21+", "+newMatr[i][j].x23+")");
        	}
        	System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------");
        return newMatr;
    }
    
}
class element{
    boolean x0;
    boolean x12;//запрет вертикальной перестройки
    boolean x21;//горизонт перестройка
    boolean x23;//вертикальная перестройки
    element(boolean x0){
        this.x0 = x0;
        x12=false;//запрет вертикальной перестройки
        x21=false;//горизонт перестройка
        x23=false;//вертикальная перестройки
    }
}
