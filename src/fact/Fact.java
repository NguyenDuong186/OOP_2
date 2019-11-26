package fact;

import correlative.Correlative;
import entity.Entity;

public class Fact {
	private Entity obj;
	private Correlative correlative;
	private Entity subj;
	
	public Fact(Entity obj, Correlative correlative, Entity subj) {
		System.out.println(obj.getName()+" "+correlative.getName()+" "+subj.getName());
	}
}
