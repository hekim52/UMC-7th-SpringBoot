//package umc.spring.validation.argumentResolver;
//
//import org.springframework.core.MethodParameter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//import umc.spring.validation.annotation.CheckPage;
//
//@Component
//public class CheckPageArgumentResolver implements HandlerMethodArgumentResolver {
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return parameter.hasParameterAnnotation(CheckPage.class)
//                && Integer.class.equals(parameter.getGenericParameterType());
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//
//        CheckPage annotation = parameter.getParameterAnnotation(CheckPage.class);
//
//        assert annotation != null;
//
//        int page = annotation.value();
//
//
//        return page - 1;
//    }
//}
