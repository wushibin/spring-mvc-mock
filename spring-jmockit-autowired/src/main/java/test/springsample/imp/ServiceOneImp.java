package test.springsample.imp;

import test.springsample.ServiceOne;

public class ServiceOneImp implements ServiceOne
{
    public String getServiceOneName()
    {
        return new String("Service One Implication");
    }
}
