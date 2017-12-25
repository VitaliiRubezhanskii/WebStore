package Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
