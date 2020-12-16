package urise.webapp.model;

import java.time.LocalDate;
import java.util.HashMap;

import static urise.webapp.model.ContactsType.EMAIL;
import static urise.webapp.model.ContactsType.PHONE;
import static urise.webapp.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        HashMap<ContactsType, String> contacts = new HashMap<>();
        HashMap<SectionType, Section> section = new HashMap<>();

        contacts.put(PHONE, "+7(921) 855-0482");
        contacts.put(EMAIL, "gkislin@yandex.ru");

        section.put(PERSONAL, new SingleLineSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        section.put(OBJECTIVE, new SingleLineSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        String[] achievment = new String[]{"Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."};

        section.put(ACHIEVEMENT, new BulletedLineSection<String>(achievment));

        String[] qualifications = new String[]{"JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "MySQL, SQLite, MS SQL, HSQLDB"};

        section.put(QUALIFICATIONS, new BulletedLineSection<String>(qualifications));

        WorkPlace[] experience = new WorkPlace[]{
                new WorkPlace("Alcatel", LocalDate.of(1997, 9, 28), LocalDate.of(2005, 1, 28), "Инженер по аппаратному и программному тестированию"),
                new WorkPlace("Siemens AG", LocalDate.of(2005, 9, 28), LocalDate.of(2007, 1, 28), "Разработчик ПО")};

        section.put(EXPERIENCE, new BulletedLineSection<WorkPlace>(experience));

        WorkPlace[] study = new WorkPlace[]{
                new WorkPlace("Alcatel", LocalDate.of(1997, 9, 28), LocalDate.of(1998, 1, 28), "6 месяцев обучения цифровым телефонным сетям (Москва)"),
                new WorkPlace("Siemens AG", LocalDate.of(2005, 9, 28), LocalDate.of(2007, 1, 28), "3 месяца обучения мобильным IN сетям (Берлин)")};

        section.put(EDUCATION, new BulletedLineSection<WorkPlace>(study));
        Resume r = new Resume("Григорий Кислин", contacts, section);

        System.out.println(r.getFullname());

        for (ContactsType c : ContactsType.values()) {
            System.out.println(r.getContact(c));
        }

        for (SectionType s : SectionType.values()) {
            System.out.println(r.getSectionValue(s));
        }
    }
}
