import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface SupplierCopy<T> {
    T get();
}

class testCar1 {
    public static void main(String[] args) throws java.lang.Exception {
        // @Bean public Docket createRestApi() {
        // return new Docket(DocumentationType.SWAGGER_2)
        // .apiInfo(apiInfo()).select()
        // .apis(RequestHandlerSelectors
        // .basePackage("com.platform.middle.user.base.web"))
        // .paths(PathSelectors.any())
        // .build()
        // .globalOperationParameters(defaultHeader()) ;
        // }
        // private static List<Parameter> defaultHeader(){
        // ParameterBuilder appType = new ParameterBuilder();
        // appType.name("app-type")
        // .description("应用类型")
        // .modelRef(new ModelRef("string"))
        // .parameterType("header")
        // .required(false).build();
        // ParameterBuilder appToken = new ParameterBuilder();
        // appToken.name("app-token")
        // .description("令牌")
        // .modelRef(new ModelRef("string"))
        // .parameterType("header")
        // .required(false).build();
        // List<Parameter> pars = new ArrayList<>();
        // pars.add(appType.build());
        // pars.add(appToken.build());
        // return pars;
        // }
        // @Bean public Docket createRestApi() { 
        //     return new Docket(DocumentationType.SWAGGER_2)
        //     .apiInfo(apiInfo())
        //     .select()
        //     .apis(RequestHandlerSelectors.basePackage("com.platform.middle.common.fastdfs.web"))
        //     .paths(PathSelectors.any()) 
        //     .build() 
        //     .securitySchemes(unifiedAuth()); 
        // } 
        // private static List<ApiKey> unifiedAuth() { 
        //     List<ApiKey> arrayList = new ArrayList(); 
        //     arrayList.add(new ApiKey("app-type", "app-type", "header")); 
        //     arrayList.add(new ApiKey("app-token", "app-token", "header")); 
        //     return arrayList; 
        // }
    }
}