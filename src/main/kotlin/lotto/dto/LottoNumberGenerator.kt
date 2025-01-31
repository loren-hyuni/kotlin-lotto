package lotto.dto

import lotto.dto.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import lotto.dto.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

object LottoNumberGenerator {

    private val LOTTO_NUMBER_SEED = LOTTO_NUMBER_RANGE.map { LottoNumber(it) }.toList()

    fun generate(): LottoNumbers = LottoNumbers(
        LOTTO_NUMBER_SEED.shuffled().subList(0, LOTTO_NUMBER_COUNT)
    )
}
