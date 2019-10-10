package main.beans;
import org.springframework.beans.factory.annotation.Value;


public class ApolloBean {
    @Value("${timeout:100}")
    private String timeout;
    private int batch;
   
    @Value("${batch:200}")
    public void setBatch(int batch) {
      this.batch = batch;
    }
   
    public String getTimeout() {
      return timeout;
    }
   
    public int getBatch() {
      return batch;
    }
    public String getInfo(){
        return "timeout:"+timeout;
    }
}
  