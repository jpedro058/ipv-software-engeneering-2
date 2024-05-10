package com.es2.blackboxpartitioning;

import java.util.Random;

public class Die

{   public static final int DEFAULT_SIDES = 6;

    private static Random ourRandNumGen = new Random();

    private final int iMyNumSides;
    private int iMyResult;


    public Die()
    {
        this(DEFAULT_SIDES);
    }

    public Die(int numSides)
    {
        if(!(numSides > 1  && numSides <= 6)) throw new AssertionError("Violation of precondition: numSides = " + numSides + "numSides must be greater than 1");

        iMyNumSides = numSides;
        iMyResult = 1;
        if(!(getResult() == 1 && getNumSides() == numSides)) throw new AssertionError();
    }

    public Die(int numSides, int result)
    {   if(!(numSides > 1 && 1 <= result && result <= numSides)) throw new AssertionError("Violation of precondition");

        iMyNumSides = numSides;
        iMyResult = result;
    }

    public int roll()
    {   iMyResult = ourRandNumGen.nextInt(iMyNumSides) + 1;

        if(!( ( 1 <= getResult() ) && ( getResult() <= getNumSides() ))) throw new AssertionError();

        return iMyResult;
    }

    public int getNumSides()
    {   return iMyNumSides; }


    public int getResult()
    {   return iMyResult;   }

    public String toString()
    {   return "Num sides " + getNumSides() + " result " + getResult();
    }
}
