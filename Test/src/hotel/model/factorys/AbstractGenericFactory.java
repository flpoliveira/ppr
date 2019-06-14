/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model.factorys;

public abstract class AbstractGenericFactory{
    public static <T> T newInstance(String className) throws ClassNotFoundException 
    {
        Class<T> clazz = (Class<T>) Class.forName(className);
        return newInstance(clazz);
    }
    public static <T> T newInstance(Class<T> clazz)
    {
        try{
            return clazz.newInstance();
        }
        catch(InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }
}