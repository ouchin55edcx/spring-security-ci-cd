package ouchin.spring_boot_cicd.spring_boot_cicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DatabaseIntegrationTests {

    @Autowired
    private YourEntityRepository yourEntityRepository; // Replace with your actual repository

    @Test
    void testDatabaseConnection() {
        YourEntity entity = new YourEntity(); // Replace with your actual entity
        entity.setField("value"); // Set fields as necessary
        yourEntityRepository.save(entity);

        assertThat(yourEntityRepository.findById(entity.getId())).isPresent();
    }
}
