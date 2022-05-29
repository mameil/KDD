package me.kdshim.kdd_j.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith({KDBaseExtension.class, MockitoExtension.class, SpringExtension.class})
public class MyTest {
}
