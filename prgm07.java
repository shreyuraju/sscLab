import java.io.IOException;
import java.util.*;
public class prgm07 {

	public Scanner sc = new Scanner(System.in);
	public void srtf() {
		int n, serviceTime=0,tot=0;
		float avgwt=0, avgta=0;
		System.out.print("Enter the number of processes:");
			n=sc.nextInt();
		int bt[] = new int[n];
		int at[] = new int[n];
		int ct[] = new int[n];
		int ta[] = new int[n];
		int wt[] = new int[n];
		int pid[] = new int[n];
		int k[] = new int[n];
		int flag[] = new int[n];
		System.out.println("Enter brust time of processes:");
		for(int i=0;i<n;i++)
			bt[i]=sc.nextInt();
		System.out.println("Enter arrival time of processes:");
		for(int i=0;i<n;i++)
			at[i] = sc.nextInt();
		for(int i=0;i<n;i++) {
			pid[i]=i+1;
			k[i]=bt[i];
			flag[i]=0;
		}
		while(true) {
			int min=99,c=n;
			if(tot==n) break;
			for(int i=0;i<n;i++) {
				if((at[i]<=serviceTime) && (flag[i]==0) && (bt[i]<min)) {
					min=bt[i];
					c=i;
				}
			}
			if(c==n) serviceTime++;
			else {
				bt[c]--;
				serviceTime++;
				if(bt[c]==0) {
					ct[c] = serviceTime;
					flag[c]=1;
					tot++;
				}
			}
		}	
		for(int i=0;i<n;i++) {
			ta[i]=ct[i]-at[i];
			wt[i]=ta[i]-k[i];
			avgwt+=wt[i];
			avgta+=ta[i];
		}
		System.out.println("Process\t Arival Time\t Brust Time\t Waiting Time\t Turn around time\t Completion time");
		for(int i=0;i<n;i++)
			System.out.println((i+1)+"\t\t"+at[i]+"\t\t"+k[i]+"\t\t"+wt[i]+"\t\t"+ta[i]+"\t\t\t"+ct[i]);
		System.out.println("Average waiting time:"+avgwt/n);
		System.out.println("Average turn around time:"+avgta/n+"\n");
		
	}
	public void rr() {
		int n,tq;
		float avgwt=0,avgta1=0;
		System.out.print("Enter the number of processes:");
			n=sc.nextInt();
		int bt[]=new int[n];
		int ct[]=new int[n];
		int ta[]=new int[n];
		int wt[]=new int[n];
		int copy[]=new int[n];
		System.out.print("Enter the time quantum:");
			tq = sc.nextint();
		System.out.println("Enter the burst time for processes:");
		for(int i=0;i<n;i++)
			bt[i]=sc.nextInt();
		System.out.println("Enter the arrival time of processes:");
		for(int i=0;i<n;i++)
			at[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			copy[i]=bt[i];
		for(int i=0;i<n;i++) {
			if(bt[i]>tq) {
				bt[i]=bt[i]-tq;
				for(int j=0;j<n;j++)
					if(i!=j && bt[j]!=0)
						wt[j]=wt[j]+tq;
			}
			else {
				for(int j=0;j<n;j++)
					if(i!=j && bt[j]!=0)
						wt[j]=at[j]+bt[i];
				bt[i]=0;
			}
		}
		for(int i=0;i<n;i++) {
			ta[i]=copy[i]+wt[i];
		}
		System.out.println("Process\t Turn around time\t Burst Time\t");
		for(int i=0;i<n;i++)
			System.out.println((i+1)+"\t\t"+ ta[i]+"\t\t"+copy[i]); 
		for(int i=0;i<n;i++) {
			ta[i]=wt[i]+copy[i];
			avgwt+=wt[i];
			avgta+=ta[i];
		}
		System.out.println("\nAverage waiting time:"+avgwt/n);
		System.out.println("Average turn around time:"+avgta/n+"\n");
	}
	public static void main(String args[]) {
		prgm07 obj= new prgm07();
		int ch;
		Scanner sc = new Scanner(System.in);
		boolean i=true;
		while(i) {
			System.out.print("1.SRTF\n2.ROUND ROBIN\n3.EXIT\nEnter Your Choice:");
				ch=sc.nextInt();
			switch(ch) {
				case 1:obj.srtf();
						break;
				case 2:obj.rr();
						break;
				case 3:i=false;
						break;
				default:System.out.println("Invalid choice");
			}
		}
	}
}
