package com.example.travel;

import com.example.travel.model.Type;
import com.example.travel.repository.TypeRepository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TypeRepositoryTest {
    @Autowired
    private TypeRepository typeRepository;

    @Test
    public void testFindByTitle() {
        // Создаем тестовую сущность
        Type testType = new Type();
        testType.setType("cafe");


        // Сохраняем тестовую сущность в репозиторий
        typeRepository.save(testType);

        // Вызываем метод для поиска
        List<Type> foundTypes = typeRepository.findByType("cafe");

        // Проверяем результат
        assert !foundTypes.isEmpty();
        assert foundTypes.size() == 1;
        Type foundType = foundTypes.get(0);
        assert foundType.getType().equals("cafe");
    }
}