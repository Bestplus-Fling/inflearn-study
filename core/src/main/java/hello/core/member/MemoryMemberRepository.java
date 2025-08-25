package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements  MemberRepository{

    // 현업에서 쓸 때는 ConcurrentHashMap을 써서 동시성 처리의 효율을 높일 필요가 있다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(long memberId) {
        return store.get(memberId);
    }
}
