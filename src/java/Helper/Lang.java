package Helper;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@SessionScoped
@Named("lang")
public class Lang implements Serializable {
   private static final long serialVersionUID = 1L;
   private String locale;

   private static Map<String,Object> countries;
      static {
      
      countries = new LinkedHashMap<String,Object>();
      countries.put("English", Locale.ENGLISH);
      countries.put("French", Locale.FRENCH);
   }

   public Map<String, Object> getCountries() {
      return countries;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   //value change event listener
   public void localeChanged(ValueChangeEvent e) {
      String newLocaleValue = e.getNewValue().toString();
      
      countries.entrySet().stream().filter((entry) -> (entry.getValue().toString().equals(newLocaleValue))).forEachOrdered((entry) -> {
          FacesContext.getCurrentInstance()
                  .getViewRoot().setLocale((Locale)entry.getValue());
       });
   }
}
