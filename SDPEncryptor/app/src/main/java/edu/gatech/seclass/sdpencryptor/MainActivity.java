package edu.gatech.seclass.sdpencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButtonFromKm;
    private RadioButton radioButtonFromMiles;
    private EditText textValue;
    private EditText inputArg1;
    private EditText inputArg2;
    private EditText textResult;

    private Map<Character,Integer> cToDMap=new HashMap<>();
    private Map<Integer,Character> DToCMap=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //radioButtonFromKm=(RadioButton) findViewById(R.id.rbFromKm);
        //radioButtonFromMiles=(RadioButton) findViewById(R.id.rbFromMile);
        textValue=(EditText) findViewById(R.id.entryTextID);
        textResult=(EditText) findViewById(R.id.textEncryptedID);
        inputArg1=(EditText) findViewById(R.id.argInput1ID);
        inputArg2=(EditText) findViewById(R.id.argInput2ID);
    }
    public void handleClick(View view)
    {



        if(view.getId()== R.id.encryptButtonID)
        {
            String result;
            String input1=inputArg1.getText().toString();
            String input2=inputArg2.getText().toString();
            String entry=textValue.getText().toString();

            System.out.println("dfsaasadfsafasfsadfasd");
            if(isValidInput(entry,input1,input2))
            {
                System.out.println("ffffffffffffffffff");
                Integer arg1=Integer.parseInt(inputArg1.getText().toString());
                Integer arg2=Integer.parseInt((inputArg2.getText().toString()));

                if(!isValidArg1(arg1.toString()))
                {
                    inputArg1.setError("Invalid Arg Input 1");
                }
                if(!isValidArg2(arg2.toString()))
                {
                    inputArg2.setError("Invalid Arg Input 2");
                }
                encrypt(arg1,arg2);
                result=encrypt(arg1,arg2);

                textResult.setText(inputArg1.getText().toString());
                textResult.setText(inputArg2.getText().toString());
                textResult.setText(result);
            }
            else
            {
                if(!isValidArg1(inputArg1.getText().toString()))
                {
                    inputArg1.setError("Invalid Arg Input 1");
                }
                if(!isValidArg2(inputArg2.getText().toString()))
                {
                    inputArg2.setError("Invalid Arg Input 2");
                }
                String value=textValue.getText().toString();
                if (!isValidEntry(value)) {
                    textValue.setError("Invalid Entry Text");
                }
                textResult.setText("");

            }

        }
        System.out.println("hhhhhhhhh");


    }
    private boolean isValidInput(String entry,String input1,String input2)
    {
        if(isValidArg1(input1)&&isValidArg2(input2)&&isValidEntry(entry))
        {
            return true;
        }
        return false;


    }




    public String encrypt(int arg1, int arg2) {
        characterToDigitMap();
        digitToCharMap();
        //System.out.println("ddd:: "+textValue.getText().toString());
       // Log.d("ddd","ddd:: "+textValue.getText().toString());
        String str=textValue.getText().toString();

        String ans="";
        for (int i = 0; i < str.length(); i++)
        {

            char c=str.charAt(i);
            if((c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
            {
                int letterorDigit=cToDMap.get(c);
                int digitAfterEncrypt=(arg1*letterorDigit+arg2)%62;
                char charAfterEncrypt=DToCMap.get(digitAfterEncrypt);
                ans=ans+charAfterEncrypt;
            }
            else
            {
                ans=ans+c;
            }



        }




        System.out.println("answer:: "+ans);
        return ans;
    }

    private static boolean isValidArg1(String arg1)
    {
        if(arg1.chars().allMatch( Character::isDigit )&&!arg1.equals(""))
        {
            int arg1_int=Integer.parseInt(arg1);
            return arg1_int >= 0 && arg1_int < 62 && gcd(arg1_int, 62) == 1;
        }
       return false;
    }
    private boolean isValidArg2(String arg2)
    {
        if(arg2.chars().allMatch( Character::isDigit )&&!arg2.equals(""))
        {
            int arg2_int=Integer.parseInt(arg2);
            return arg2_int>=1&&arg2_int<62;
        }
        return false;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    private void characterToDigitMap()
    {
        //A-B-C-D-E-F-G-H-I-J-K-L-M-N-O-P-Q-R-S-T-U-V-W-X-Y-Z
        cToDMap.put('0',0);
        cToDMap.put('1',1);
        cToDMap.put('2',2);
        cToDMap.put('3',3);
        cToDMap.put('4',4);
        cToDMap.put('5',5);
        cToDMap.put('6',6);
        cToDMap.put('7',7);
        cToDMap.put('8',8);
        cToDMap.put('9',9);
        cToDMap.put('A',10);
        cToDMap.put('B',11);
        cToDMap.put('C',12);
        cToDMap.put('D',13);
        cToDMap.put('E',14);
        cToDMap.put('F',15);
        cToDMap.put('G',16);
        cToDMap.put('H',17);
        cToDMap.put('I',18);
        cToDMap.put('J',19);
        cToDMap.put('K',20);
        cToDMap.put('L',21);
        cToDMap.put('M',22);
        cToDMap.put('N',23);
        cToDMap.put('O',24);
        cToDMap.put('P',25);
        cToDMap.put('Q',26);
        cToDMap.put('R',27);
        cToDMap.put('S',28);
        cToDMap.put('T',29);
        cToDMap.put('U',30);
        cToDMap.put('V',31);
        cToDMap.put('W',32);
        cToDMap.put('X',33);
        cToDMap.put('Y',34);
        cToDMap.put('Z',35);
        cToDMap.put('a',36);
        cToDMap.put('b',37);
        cToDMap.put('c',38);
        cToDMap.put('d',39);
        cToDMap.put('e',40);
        cToDMap.put('f',41);
        cToDMap.put('g',42);
        cToDMap.put('h',43);
        cToDMap.put('i',44);
        cToDMap.put('j',45);
        cToDMap.put('k',46);
        cToDMap.put('l',47);
        cToDMap.put('m',48);
        cToDMap.put('n',49);
        cToDMap.put('o',50);
        cToDMap.put('p',51);
        cToDMap.put('q',52);
        cToDMap.put('r',53);
        cToDMap.put('s',54);
        cToDMap.put('t',55);
        cToDMap.put('u',56);
        cToDMap.put('v',57);
        cToDMap.put('w',58);
        cToDMap.put('x',59);
        cToDMap.put('y',60);
        cToDMap.put('z',61);



    }
    public void digitToCharMap()
    {
        DToCMap.put(0,'0');
        DToCMap.put(1,'1');
        DToCMap.put(2,'2');
        DToCMap.put(3,'3');
        DToCMap.put(4,'4');
        DToCMap.put(5,'5');
        DToCMap.put(6,'6');
        DToCMap.put(7,'7');
        DToCMap.put(8,'8');
        DToCMap.put(9,'9');
        DToCMap.put(10,'A');
        DToCMap.put(11,'B');
        DToCMap.put(12,'C');
        DToCMap.put(13,'D');
        DToCMap.put(14,'E');
        DToCMap.put(15,'F');
        DToCMap.put(16,'G');
        DToCMap.put(17,'H');
        DToCMap.put(18,'I');
        DToCMap.put(19,'J');
        DToCMap.put(20,'K');
        DToCMap.put(21,'L');
        DToCMap.put(22,'M');
        DToCMap.put(23,'N');
        DToCMap.put(24,'O');
        DToCMap.put(25,'P');
        DToCMap.put(26,'Q');
        DToCMap.put(27,'R');
        DToCMap.put(28,'S');
        DToCMap.put(29,'T');
        DToCMap.put(30,'U');
        DToCMap.put(31,'V');
        DToCMap.put(32,'W');
        DToCMap.put(33,'X');
        DToCMap.put(34,'Y');
        DToCMap.put(35,'Z');
        DToCMap.put(36,'a');
        DToCMap.put(37,'b');
        DToCMap.put(38,'c');
        DToCMap.put(39,'d');
        DToCMap.put(40,'e');
        DToCMap.put(41,'f');
        DToCMap.put(42,'g');
        DToCMap.put(43,'h');
        DToCMap.put(44,'i');
        DToCMap.put(45,'j');
        DToCMap.put(46,'k');
        DToCMap.put(47,'l');
        DToCMap.put(48,'m');
        DToCMap.put(49,'n');
        DToCMap.put(50,'o');
        DToCMap.put(51,'p');
        DToCMap.put(52,'q');
        DToCMap.put(53,'r');
        DToCMap.put(54,'s');
        DToCMap.put(55,'t');
        DToCMap.put(56,'u');
        DToCMap.put(57,'v');
        DToCMap.put(58,'w');
        DToCMap.put(59,'x');
        DToCMap.put(60,'y');
        DToCMap.put(61,'z');
    }
    private boolean isValidEntry(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {

            char c=str.charAt(i);
            if((c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
            {
                return true;
            }



        }
        return false;
    }
}