package za.ac.nwu.logic;

public class Account<E>
{
    private E data;//Generic data type for currency
    private String name;//Name of account holder
    private String email;//Email of account holder
    //private int type;//Type of currency

    private void add(E e, String email)
    {
        try{

        }catch(UnsupportedOperationException ex)
        {
            System.out.println(ex.getMessage()+": Could not resolve.");
        }

    }

    private String remove(String email, String name)
    {

       return email;
    }

    private boolean check(String email)
    {
        if(1==1)
        {
            return true;
        }else
        {
            return false;
        }
    }

    public E view(String email, String name)
    {
        return data;
    }
//    public static void main(String[] args)
//    {
//        System.out.println("hello");
//    }
}
