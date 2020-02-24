package com.mycompany.common.demo.entity;

/**
 * 数据类型
 */
public class DataType {

    //整形 ******************************************************************

    public Byte bigByte = 12;

    public byte smallByte = Byte.MAX_VALUE;

    public Short bigShort = Short.MAX_VALUE;

    public short smallShort = Short.MIN_VALUE;

    public Integer bigInteger = 0;


    public int smallInt = Integer.MIN_VALUE;

    public Long bigLong = 11L;

    public long smallLong = Long.MAX_VALUE;

    //浮点型

    public Float bigFloat = 1231f;

    public float smallFloat = Float.MAX_VALUE;

    public Double bigDouble;

    public double smallDouble = Double.MAX_VALUE;

    // Boblean

    public Boolean bigBoolean;

    public boolean smallBoolean = Boolean.TRUE;

    // 字符型

    public Character bigCharacter;

    public char smallChar = Character.MAX_VALUE;


    private final String p;


    public DataType(String p) {
        this.p = p;
    }

    public Short getBigShort() {
        return bigShort;
    }

    public void setBigShort(Short bigShort) {
        this.bigShort = bigShort;
    }

    public String getString() {
        return "";
    }

    public void test() {
        this.bigBoolean = false;
        smallBoolean = true;
        getString();
        this.getString();
    }
}
