//Jonah Banks
//This class has all the methods for canAttend and main method
//2/9/26
import java.util.ArrayList;

public class CanAttend {

	//precondition: meetings is an arraylist of meetingIntervals
	//postcondition: boolean returned, false if cannot attend meetings
	public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
		//your implementation here
		System.out.println(meetings);
		for (int i=0;i<meetings.size();i++){
			int startI =meetings.get(i).getStart();
			int durationI=meetings.get(i).getEnd()-startI;
			for(int j=i+1;j<meetings.size();j++){
                int startJ=meetings.get(j).getStart();
                int durationJ=meetings.get(j).getEnd()-startJ;
                if(startI>=startJ&&(startJ+durationJ)>startI){
                    return false;
                }else if(startI<=startJ&&startJ<(startI+durationI)){
                    return false;
                }
            }
        }
            return true;
    }
	public static void main(String[] args) {
		ArrayList<MeetingInterval> meet = new ArrayList<MeetingInterval>();
		for(int i =0; i<10; i++) {
			int start = (int)(Math.random()*2399);
			int end = start + ((int)(Math.random()*(2399-start)));
			meet.add(new MeetingInterval(start, end));
		}
		ArrayList<MeetingInterval> m2=new ArrayList<MeetingInterval>();
		for(int k=0;k<=1200;k+=100){
			m2.add(new MeetingInterval(k,k+99));
		}
		ArrayList<MeetingInterval> m3=new ArrayList<MeetingInterval>();
		for(int l=0;l<=1200;l+=100){
			m3.add(new MeetingInterval(l,l+101));
		}
		System.out.println(canAttend(m3) ? "There is no conflict with attending "+m3+" meetings":"Can't attend "+m3+" meetings due to conflict");
		System.out.println(canAttend(m2) ? "There is no conflict with attending "+m2+" meetings":"Can't attend "+m2+" meetings due to conflict");
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");
		//please include additional testing here!
	}
}