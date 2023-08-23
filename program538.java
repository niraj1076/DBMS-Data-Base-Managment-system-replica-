//Parsing query
import java.util.*;

class Student
{
    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;        // this is to make rollno to prinmary key

    static
    {
        Generator = 0;
    }

    public Student(String str, int X, int Y)
    {
        this.Rno = ++Generator;
        this.Name = str;
        this.Age = X;
        this.Marks = Y;
    }

    public void Display()
    {
       
        System.out.println(this.Rno + "\t\t" + this.Name+ "\t" + this.Age + "\t" + this.Marks);

    }
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<Student>();
    }

    public void StartDBMS()
    {
        System.out.println("Marvellous DBMS started succesfully...");
        System.out.println("Table Schema created succesfully...");
        
        String Query;
        String Tokens[];

        Scanner sobj = new Scanner(System.in);
        int TokensCount = 0;

        while(true)
        {
            System.out.print("Marvellous DBMS : ");
            Query = sobj.nextLine();

            Tokens = Query.split(" ");      //using the " " to seprate the words and these words are tokenized. 

            TokensCount = Tokens.length;

            if(TokensCount == 1)
            {
                if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you for using Marellous DBMS.....");
                    break;
                }
            }
            else if(TokensCount == 2)
            {

            }
            else if(TokensCount == 3)
            {

            }
            else if(TokensCount == 4)
            {
                if("select".equals(Tokens[0]))
                {
                    SelectFrom();
                }
            }
            else if(TokensCount == 5)
            {
                if("select".equals(Tokens[0]))
                {
                    if("MAX".equals(Tokens[1]))
                    {
                        System.out.println("Maxmimum marks are: "+ Aggreate_Max());
                    }
                    else if("MIN".equals(Tokens[1]))
                    {
                        System.out.println("Minmimum marks are: "+ Aggreate_Min());
                    }
                    else if("AVG".equals(Tokens[1]))
                    {
                        System.out.println("Average marks are: "+ Aggreate_Avg());
                    }
                    else if("SUM".equals(Tokens[1]))
                    {
                        System.out.println("Sum marks are: "+ Aggreate_Sum());
                    }
                }
            }
            else if(TokensCount == 6)
            {

            }
            else if(TokensCount == 7)
            {
                if("insert".equals(Tokens[0]))
                {
                    InsertIntoTable(Tokens[4], Integer.parseInt(Tokens[5]), Integer.parseInt(Tokens[6]));
                }
                else if("select".equals(Tokens[0]))
                {
                    if("rollno".equals(Tokens[5]))
                    {
                        SelectFromRno(Integer.parseInt(Tokens[6]));
                    }
                    else if("name".equals(Tokens[5]))
                    {
                        SelectFromName(Tokens[6]);
                    }
                    else if("age".equals(Tokens[5]))
                    {
                        SelectFromAge(Integer.parseInt(Tokens[6]));
                    }
                    else if("marks".equals(Tokens[5]))
                    {
                        SelectFromMarks(Integer.parseInt(Tokens[6]));                   
                    }
                }
                else if("delete".equals(Tokens[0]))
                {
                    DeleteFrom(Integer.parseInt(Tokens[6]));
                }
            }
            
        }

    }

    //insert into table student values(______, _______,______);         real sql query
    //  insert into student value Rahul 23 67  (query for this application )
    public void InsertIntoTable(String name, int age, int marks)
    {
        Student sobj = new Student(name, age, marks);
        lobj.add(sobj);
    }

    //select * from student
    public void SelectFrom()
    {
        System.out.println("Records from the student table are : ");

        System.out.println("_______________________________________________________");
        System.out.println("Roll no.\t" + "Name \t" + "Age \t" + "Marks\t");
        System.out.println("_______________________________________________________");
        for(Student sref : lobj)
        {
            sref.Display();
        }
        System.out.println("_______________________________________________________");

    }

    //select * from student where rollno 4
    public void SelectFromRno(int no)
    {
        System.out.println("Records from the student table are : ");

        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                sref.Display();
                break;
            }
        }
    }
    
    //select * from student where name Rahul
    public void SelectFromName(String name)
    {
        System.out.println("Records from the student table are : ");
        
        for(Student sref : lobj)
        {
            if(name.equals(sref.Name))
            {
                sref.Display();
                break;
            }
        }
    }

    //select * from student where age 23
    public void SelectFromAge(int age)
    {
        System.out.println("Records from the student table are : ");

        for(Student sref : lobj)
        {
            if(sref.Age == age)
            {
                sref.Display();
                break;
            }
        }
    }

    //select * from student where marks 45
    public void SelectFromMarks(int marks)
    {
        System.out.println("Records from the student table are : ");

        for(Student sref : lobj)
        {
            if(sref.Marks == marks)
            {
                sref.Display();
                break;
            }
        }
    }

    //delete from student where Rollno = 4;
    public void DeleteFrom(int no)
    {
        int i = 0;        
        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                lobj.remove(i);
                break;
            }
            i++;
        }
    }
    
    //select MAX(marks) from student
    public int Aggreate_Max()
    {
        Student temp = lobj.get(0);
        int iMax = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks > iMax)
            {
                iMax = sref.Marks;
            }
        }
        return iMax;
    }


    //select MIN(marks) from student
    public int Aggreate_Min()
    {
        Student temp = lobj.get(0);
        int iMin = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks < iMin)
            {
                iMin = sref.Marks;
            }
        }
        return iMin;
    }

    //select SUM(marks) from student
    public int Aggreate_Sum()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return iSum;
    }

    //select SUM(marks) from student average
    public float Aggreate_Avg()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return (iSum/(lobj.size()));
    }

}

class program538
{
    public static void main(String arg[])
    {
       DBMS obj = new DBMS();
       obj.StartDBMS();

       /* 
       obj.InsertIntoTable("Rahul", 23, 89);
       obj.InsertIntoTable("Sager", 26, 98);
       obj.InsertIntoTable("Pooja", 20, 56);
       obj.InsertIntoTable("Sayali", 30, 78);
       obj.InsertIntoTable("Tejas", 29, 68);

       obj.SelectFrom();
       obj.SelectFrom(4);
       obj.SelectFrom("Pooja");

       System.out.println("Maximium marks are : " + obj.Aggreate_Max());
       System.out.println("Minmimun marks are : " + obj.Aggreate_Min());
       System.out.println("Sum marks are : " + obj.Aggreate_Sum());
       System.out.println("Average marks are : " + obj.Aggreate_Avg());

       obj.DeleteFrom(4);
       obj.SelectFrom();

       */

    }
}


/*
 *  Insert query
 *  insert into student value Rahul 23 67
 *     0    1      2     3     4    5   6
 *  Number of token are = 7
 * _______________________________________________________
 *  select query 
 *  select * from student
 *    0    1  2     3 
 *  number of tokens = 4
 * ______________________________________________________
 * 
 * select query for specfic 
 * 
 * select * from student where rollno 3
 *    0   1   2     3      4      5   6
 * numbers of tockens = 7
 * 
 * * select * from student where name rahul
 *    0   1   2     3      4      5     6
 * numbers of tockens = 7
 * 
 * * select * from student where age  21
 *    0   1   2     3      4      5   6
 * numbers of tockens = 7
 * 
 * * select * from student where marks  66
 *    0   1   2     3      4      5     6
 * numbers of tockens = 7
 * ______________________________________________________
 * 
 *  delete query
 *  delete from student where rno = 3
 *     0     1     2      3    4  5 6
 * numbers of token  = 7
 * ____________________________________________________
 * 
 * select Max age from student
 *    0    1   2   3      4
 * numbers of tokens = 5
 */