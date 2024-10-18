<?php

class Library
{
    private $books = [];
    private $filePath;

    public function __construct($filePath)
    {
        $this->filePath = $filePath;
        $this->loadBooks();
    }

    private function loadBooks()
    {
        if (file_exists($this->filePath)) {
            $data = json_decode(file_get_contents($this->filePath), true);
            foreach ($data as $bookData) {
                $this->books[$bookData['id']] = new Book($bookData['id'], $bookData['title'], $bookData['author']);
            }
        }
    }

    public function saveBooks()
    {
        $data = [];
        foreach ($this->books as $book) {
            $data[] = [
                'id' => $book->id,
                'title' => $book->title,
                'author' => $book->author,
            ];
        }
        file_put_contents($this->filePath, json_encode($data, JSON_PRETTY_PRINT));
    }

    public function addBook($title, $author)
    {
        $id = uniqid();
        $book = new Book($id, $title, $author);
        $this->books[$id] = $book;
        $this->saveBooks();
        echo "Book added: $title\n";
    }

    public function deleteBook($id)
    {
        if (isset($this->books[$id])) {
            unset($this->books[$id]);
            $this->saveBooks();
            echo "Book with ID $id deleted.\n";
        } else {
            echo "Book with ID $id not found.\n";
        }
    }

    public function listBooks()
    {
        if (empty($this->books)) {
            echo "No books available.\n";
            return;
        }
        foreach ($this->books as $book) {
            echo "ID: {$book->id}, Title: {$book->title}, Author: {$book->author}, Year: {$book->year}\n";
        }
    }
}