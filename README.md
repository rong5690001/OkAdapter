To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

``` 
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```


 
 Step 2. Add the dependency
  
 	

``` 
dependencies {
  compile 'com.github.rong5690001:OkAdapter:1.0.2'
}
```

**用法：**

``` stylus
List data = new ArrayList();
data.add("String");
data.add(1);
data.add(0.1f);
data.add("String");
data.add(1);
data.add(0.1f);
data.add("String");
data.add(new TestBean());
OkAdapter okAdapter = new OkAdapter(this, data);
okAdapter.register(String.class, new ItemStringBind());
okAdapter.register(Integer.class, new ItemIntegerBind());
okAdapter.register(Float.class, new ItemFloatBind());
okAdapter.register(TestBean.class, new ItemTestBeanBind());
mRecyclerView.setAdapter(okAdapter);
```





