package domain.lotto;

import domain.result.LottoResult;
import domain.result.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult getLottoResults(WinningLotto winningLotto) {
        List<Rank> ranks = lottoTickets.stream()
                .map(winningLotto::getRank)
                .collect(Collectors.toList());
        return new LottoResult(ranks);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}