package letscode.sarafan.controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("heroes")
public class HeroesController {
//    private final HeroesService heroesService;
//
//    @Autowired
//    public HeroesController(HeroesService heroesService) {
//        this.heroesService = heroesService;
//    }
//
//    @GetMapping("{id}")
//    @JsonView(Views.FullHeroes.class)
//    public User get(@PathVariable("id") User user) {
//        return user;
//    }
//
//    @PostMapping("change-subscription/{channelId}")
//    @JsonView(Views.FullHeroes.class)
//    public User changeSubscription(
//            @AuthenticationPrincipal User subscriber,
//            @PathVariable("channelId") User channel
//    ) {
//        if (subscriber.equals(channel)) {
//            return channel;
//        } else {
//            return heroesService.changeSubscription(channel, subscriber);
//        }
//    }
//
//    @GetMapping("get-subscribers/{channelId}")
//    @JsonView(Views.IdName.class)
//    public List<UserSubscription> subscribers(
//            @PathVariable("channelId") User channel
//    ) {
//        return heroesService.getSubscribers(channel);
//    }
//
//    @PostMapping("change-status/{subscriberId}")
//    @JsonView(Views.IdName.class)
//    public UserSubscription changeSubscriptionStatus(
//            @AuthenticationPrincipal User channel,
//            @PathVariable("subscriberId") User subscriber
//    ) {
//        return heroesService.changeSubscriptionStatus(channel, subscriber);
//    }
}
