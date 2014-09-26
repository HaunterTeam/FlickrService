/**
 * Created by les on 23/09/14.
 */
public class MainClass {
    public static void main(String[] args) {

        HealthProfileReader reader;
        if(args.length == 0)
            reader = new HealthProfileReader("resources/people.xml");
        else{
            reader = new HealthProfileReader(args[0]);

            if(args.length > 2){
                String method = args[1];

                if(method.equals("createNewPerson"))
                    reader.addPerson(new Person(args[3],args[4], new HealthProfile(), args[2]));
            }
        }
        System.out.println("Now loading DB");
        reader.loadDB();

    }
}
