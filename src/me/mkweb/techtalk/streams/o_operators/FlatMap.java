package me.mkweb.techtalk.streams.o_operators;

import me.mkweb.techtalk.util.Mock;
import me.mkweb.techtalk.util.Repository;
import me.mkweb.techtalk.util.internal.CompanyRepository;
import me.mkweb.techtalk.util.model.Company;

public class FlatMap {
    private static Repository<Company> companyRepository = CompanyRepository.INSTANCE;

    public static void main(String[] args) {
        Mock.init();

        companyRepository.findAll().stream()
                .flatMap(company -> company.getEmployees().stream())
                .forEach(employee -> System.out.println(String.format("%s %s has a Job and gets %s$ per month", employee.getFirstName(), employee.getSecondName(), employee.getSalary())));
    }
}
