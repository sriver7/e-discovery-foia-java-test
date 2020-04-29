package com.gdit.ediscovery.foia.vango;

import com.gdit.ediscovery.foia.vango.quote.Quote;
import com.gdit.ediscovery.foia.vango.quote.QuoteProcessor;
import com.gdit.ediscovery.foia.vango.quote.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class VangoInitializer implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private QuoteProcessor quoteProcessor;

  @Autowired
  private QuoteRepository quoteRepository;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    String harperLee = "“Atticus said to Jem one day, “I’d rather you shot at tin cans in the backyard, but I know you’ll go after birds. Shoot all the blue jays you want, if you can hit ‘em, but remember it’s a sin to kill a mockingbird.” That was the only time I ever heard Atticus say it was a sin to do something, and I asked Miss Maudie about it. “Your father’s right,” she said. “Mockingbirds don’t do one thing except make music for us to enjoy. They don’t eat up people’s gardens, don’t nest in corn cribs, they don’t do one thing but sing their hearts out for us. That’s why it’s a sin to kill a mockingbird.” – Harper Lee, To Kill a Mockingbird'";
    quoteRepository.save(new Quote(harperLee));

    String stephenKing = "“The most important things are the hardest to say. They are the things you get ashamed of, because words diminish them — words shrink things that seemed limitless when they were in your head to no more than living size when they’re brought out. But it’s more than that, isn’t it? The most important things lie too close to wherever your secret heart is buried, like landmarks to a treasure your enemies would love to steal away. And you may make revelations that cost you dearly only to have people look at you in a funny way, not understanding what you’ve said at all, or why you thought it was so important that you almost cried while you were saying it. That’s the worst, I think. When the secret stays locked within not for want of a teller but for want of an understanding ear.” Stephen King, Different Seasons'";
    quoteRepository.save(new Quote(stephenKing));

    quoteProcessor.process();
  }
}
