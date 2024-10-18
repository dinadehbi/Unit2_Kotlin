<?php

require_once 'books.php';
require_once 'manager.php';

$library = new Library('library.json');

while (true) {
    echo "\nLibrary System\n";
    echo "1. Add Book\n";
    echo "2. Delete Book\n";
    echo "3. List Books\n";
    echo "4. Exit\n";
    echo "Choose an option: ";
    $choice = trim(fgets(STDIN));

    switch ($choice) {
        case 1:
            echo "Enter title: ";
            $title = trim(fgets(STDIN));
            echo "Enter author: ";
            $author = trim(fgets(STDIN));
            $library->addBook($title, $author);
            break;
        case 2:
            echo "Enter book ID to delete: ";
            $id = trim(fgets(STDIN));
            $library->deleteBook($id);
            break;
        case 3:
            $library->listBooks();
            break;
        case 4:
            exit("Exiting...\n");
        default:
            echo "Invalid choice. Please try again.\n";
    }
}