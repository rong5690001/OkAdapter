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
  compile 'com.github.rong5690001:OkAdapter:1.0.1'
}
```

**用法：**

``` stylus
private IMultiType mIMultiType = new IMultiType() {
        @Override
        public int getItemViewType(Object object, int position) {
            if (object instanceof String) {
                return 0;
            } else if (object instanceof Integer) {
                return 1;
            } else if (object instanceof Float) {
                return 2;
            } else {
                return 3;
            }
        }

        @Override
        public IItemViewBind getItemViewBind(int viewType) {
            switch (viewType) {
                case 0:
                    return new ItemStringBind();
                case 1:
                    return new ItemIntegerBind();
                case 2:
                    return new ItemFloatBind();
                case 3:
                    return new ItemTestBeanBind();
                default:
                    return new ItemStringBind();
            }
        }
    };
```

``` stylus
List data = new ArrayList();
data.add("String");
data.add(1);
data.add(0.1f);
data.add(new TestBean());
mRecyclerView.setAdapter(new OkAdapter(this, data, mIMultiType));
```




