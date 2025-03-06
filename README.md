1. CardMatcherTest
testNameContainsFilter: правильно ли фильтруется имя карты по nameContains.
testColorIdentityFilter: правильность фильтрации по colorIdentity.
testExclusiveMatchTrue: проверяем exclusiveMatch == true карты фильтруются по обоим критериям.
testExclusiveMatchFalse: проверяем exclusiveMatch == false карты должны подходить хотя бы под один фильтр.

2. ColorTest
parse_shouldReturnCorrectColor_whenValidAbbreviation: правильность парсинга цветовых аббревиатур.
parse_shouldReturnCorrectColor_whenValidFullName: работа с полными названиями цветов.
parse_shouldThrowException_whenInvalidValue: при неверном значении выбрасывается исключение.
parse_shouldThrowException_whenNull: при передаче null выбрасывается NullPointerException.

3. RawCardToCardMapperTest
convert_ShouldMapNameCorrectly: проверяется правильность маппинга имени карты из RawCard.
convert_ShouldMapColorIdentityCorrectly: тестирует как маппится colorIdentity.
convert_ShouldMapConvertedManaCostCorrectly: проверяем что cmc правильно маппится в convertedManaCost
