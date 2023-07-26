import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class OrderCardDeliveryTest {
    String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    @Test

    public void shouldTest() {
        open("http://localhost:9999");
        $("data-test-id=city input").setValue("Москва");
        $("data-test-id=date input").setValue("26.07.2023");
        $("data-test-id=name input").setValue("Петров Иван");
        $("data-test-id=phone input").setValue("+79000000000");
        $("data-test-id=agreement").click();
        $(".button").click();
        $("data-test-id=notification").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $(withText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
}
