package lotto.domain

import lotto.dto.LottoNumber

data class LottoNumbers(
    val numbers: List<LottoNumber>
) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 번호는 중복되지 않아야 합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) })

    fun matchedLottoNumberCount(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.numbers.toSet()).count()
    }

    operator fun contains(lottoNumber: LottoNumber) = lottoNumber in numbers

    operator fun contains(lottoNumber: Int) = contains(LottoNumber(lottoNumber))

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000
        fun from(numbers: List<Int>) = LottoNumbers(numbers.map { LottoNumber(it) })
    }
}
