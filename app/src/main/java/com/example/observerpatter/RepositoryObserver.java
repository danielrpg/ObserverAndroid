package com.example.observerpatter;

public interface RepositoryObserver {
    void onUserDataChanged(String fullName, int age);
}
