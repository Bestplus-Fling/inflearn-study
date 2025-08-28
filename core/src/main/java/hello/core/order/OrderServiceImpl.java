package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // OCP, DIP 같은 객체지향 설계 원칙(공부 필요)
    /*
        정액 할인에서 정률 할인으로 변경
        Impl에서 DiscountPolicy 뿐 아니라 RateDiscountPolicy, FixDiscountPolicy도 의존하고 있음
        => 추상에도 의존, 구체에도 의존하고 있음 => DIP 위반(추상에만 의존하도록 변경)!
        정액에서 정률로 변경했을 때, Impl의 소스코드도 함께 변경하고 있음 => OCP 위반!
    */
    private DiscountPolicy discountPolicy;  // 추상에만 의존하도록 변경
    // 하지만 이대로 실행하면 NullPointException 발생
    //

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
