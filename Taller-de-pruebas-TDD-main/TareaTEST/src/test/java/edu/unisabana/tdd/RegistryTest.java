package edu.unisabana.tdd;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateDeadPerson() {
        Person p = new Person("Carlos", 1, 30, Gender.MALE, false);
        Assert.assertEquals(RegisterResult.DEAD, registry.registerVoter(p));
    }

    @Test
    public void validateUnderage() {
        Person p = new Person("Ana", 2, 17, Gender.FEMALE, true);
        Assert.assertEquals(RegisterResult.UNDERAGE, registry.registerVoter(p));
    }

    @Test
    public void validateInvalidAge() {
        Person p = new Person("Juan", 3, -5, Gender.MALE, true);
        Assert.assertEquals(RegisterResult.INVALID_AGE, registry.registerVoter(p));
    }

    @Test
    public void validateDuplicate() {
        Person p1 = new Person("Maria", 4, 30, Gender.FEMALE, true);
        Person p2 = new Person("Maria", 4, 30, Gender.FEMALE, true);
        registry.registerVoter(p1);
        Assert.assertEquals(RegisterResult.DUPLICATED, registry.registerVoter(p2));
    }

    @Test
    public void validateValidPerson() {
        Person p = new Person("Jose", 5, 25, Gender.MALE, true);
        Assert.assertEquals(RegisterResult.VALID, registry.registerVoter(p));
    }
}
