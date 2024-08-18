<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Input Data</title>
    <link rel="stylesheet" href="<?php echo base_url('assets/css/style.css'); ?>">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            width: 100%;
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            margin-bottom: 20px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #fafafa;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select, button {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            opacity: 0.8;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group select {
            height: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Input Data</h1>

        <!-- Form for Adding New Project -->
        <h2>Add New Project</h2>
        <form action="<?php echo base_url('main/add_project'); ?>" method="post">
    <label for="id_pk">Project ID:</label>
    <input type="number" name="id_pk" id="id_pk" required>

    <label for="nama_proyek">Project Name:</label>
    <input type="text" name="nama_proyek" id="nama_proyek" required>

    <label for="client">Client:</label>
    <input type="text" name="client" id="client" required>

    <label for="tgl_mulai">Start Date:</label>
    <input type="date" name="tgl_mulai" id="tgl_mulai" required>

    <label for="tgl_selesai">End Date:</label>
    <input type="date" name="tgl_selesai" id="tgl_selesai" required>

    <label for="pimpinan_proyek">Project Leader:</label>
    <input type="text" name="pimpinan_proyek" id="pimpinan_proyek" required>

    <label for="keterangan">Description:</label>
    <input type="text" name="keterangan" id="keterangan" required>

    <label for="lokasi">Location:</label>
    <select name="lokasi[]" id="lokasi" multiple>
        <?php foreach ($locations as $location): ?>
            <option value="<?php echo $location->id_pk; ?>"><?php echo $location->nama_lokasi; ?></option>
        <?php endforeach; ?>
    </select>

    <button type="submit">Add Project</button>
    <button onclick="window.location.href = '<?php echo base_url('main'); ?>'">Back</button>
</form>

        <!-- Form for Adding New Location -->
        <h2>Add New Location</h2>
        <form action="<?php echo base_url('main/add_location'); ?>" method="post">
            <div class="form-group">
                <label for="id_pk">Location ID:</label>
                <input type="number" name="id_pk" id="id_pk">
            </div>

            <div class="form-group">
                <label for="nama_lokasi">Location Name:</label>
                <input type="text" name="nama_lokasi" id="nama_lokasi" required>
            </div>

            <div class="form-group">
                <label for="negara">Country:</label>
                <input type="text" name="negara" id="negara" required>
            </div>

            <div class="form-group">
                <label for="provinsi">Province:</label>
                <input type="text" name="provinsi" id="provinsi" required>
            </div>

            <div class="form-group">
                <label for="kota">City:</label>
                <input type="text" name="kota" id="kota" required>
            </div>

            <button type="submit">Add Location</button>
            <button onclick="window.location.href = '<?php echo base_url('main'); ?>'">Back</button>
        </form>
    </div>
</body>
</html>
