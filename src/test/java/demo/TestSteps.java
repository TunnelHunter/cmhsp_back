package demo;

import cn.psychology.Util.RespCode;
import cn.psychology.Util.RespEntity;
import cn.psychology.dao.MusicRepository;
import cn.psychology.service.MusicService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestSteps extends AbstractDefs {
@Autowired
    private MusicRepository musicRepository;

private String mid;
@Given("^Generate testCase for \"([^\"]*)\"$")
    public void generateTestCase(String id){
    mid =id;
}
@Then("^finish$")
public List finish()
{return musicRepository.findAllByMusicsceneId(mid);}


}
