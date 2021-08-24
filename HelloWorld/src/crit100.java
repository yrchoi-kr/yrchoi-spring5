
public class crit100 {

	public static void main(String[] args) {
		double base_crit = 0.5;
		//변수 초기화
		double last_crit = 0;
		double critParam = base_crit;
		int hit=1;
		System.out.println("크리티컬이"+base_crit*100+"%일때");
		for(hit=1;last_crit<0.99 ;hit++) {
			for(int i=1;i<hit;i++) {
				critParam = critParam*(1-base_crit);
			}
		last_crit = last_crit + critParam;	
		//critParam 초기화
		critParam = base_crit;
		System.out.println(hit+"대 때렸을때 크리가 1대 터질 확률" + last_crit*100+"%");
		}
	}
}
