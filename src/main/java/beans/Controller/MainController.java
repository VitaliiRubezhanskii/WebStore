package beans.Controller;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller

public class MainController{

  public Functional functional;

  @Autowired
  public MainController(Functional functional){
      this.functional=functional;

  }

    @RequestMapping("/hello")

   public String getModel (){
        Functional message=new Functional();

        ModelMap modelAndView=new ModelMap();
        modelAndView.addAttribute("message",message.sendMessage("Help me fuck me")) ;
        return "hello";
    }




}
