public class prime_numbers{
    public static void main(String[] args){
        int i,j;
        for(i=1;i<=1000;i++){
            for(j=2;j<=i/2;j++){
                if(i%j==0) break;}
            System.out.printf("%d",i);
        }
    }