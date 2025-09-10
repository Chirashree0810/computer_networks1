import java.util.*;
public class Pgm1 {
    public static void main(String[] args) {
        int i;
        int a[]=new int[20];
        int sent;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of packets");
        int n=sc.nextInt();
        System.out.println("enter the bucket capacity");
        int bucket_capacity=sc.nextInt();
        System.out.println("enter the output rate");
        int rate=sc.nextInt();
        System.out.println("enter the number of packets");
        for(i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("clock \t packetsize \t accept \t sent \t remaining \t");
        int bucket_remaining=0;
        int accept;
        for(i=1;i<=n;i++){
            if(a[i]!=0){
                if(bucket_remaining+a[i]>bucket_capacity)
                accept=-1;
                else{
                    accept=a[i];
                    bucket_remaining+=a[i];
                }
            }
            else{
                accept=0;
            }
            if(bucket_remaining!=0){
                if(bucket_remaining<rate){
                    sent=bucket_remaining;
                    bucket_remaining=0;
                }
                else{
                    sent=rate;
                    bucket_remaining=bucket_remaining-rate;
                }
            }
            else
            sent=0;
            if(accept==-1)
            System.out.println(+i+"\t \t"+a[i]+"\t dropped \t"+sent+"\t"+bucket_remaining);
            else
            System.out.println(+i+"\t \t"+a[i]+"\t \t"+accept+"\t"+sent+"\t"+bucket_remaining);
        }
    }
}
