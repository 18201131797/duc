get是空的话会通过反射重新执行load方法。
功能项目中load包下使用@Autowired注解无效需要使用 
private IBaseLaunch<ICacheFactory> launch = SpringLoad.getInstance(IBaseLaunch.class);
方式。