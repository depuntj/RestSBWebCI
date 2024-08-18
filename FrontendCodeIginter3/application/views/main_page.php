<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="<?php echo base_url('assets/css/style.css'); ?>">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 80%;
            max-width: 1000px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .btn {
            display: inline-block;
            padding: 8px 16px;
            margin: 0 5px;
            border: none;
            border-radius: 4px;
            color: #fff;
            text-decoration: none;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
        }
        .btn-primary {
            background-color: #007bff;
        }
        .btn-secondary {
            background-color: #6c757d;
        }
        .btn-edit {
            background-color: #28a745;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn:hover {
            opacity: 0.8;
        }
        .actions {
            margin-bottom: 20px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Main Page</h1>
        
        <div class="actions">
            <a href="<?php echo base_url('main/input_data'); ?>" class="btn btn-primary">Add Project</a>
        </div>
        
        <!-- Projects Table -->
        <h2>Projects</h2>
        <table>
            <thead>
                <tr>
                    <th>Project Name</th>
                    <th>Client</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Project Leader</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php if (isset($projects) && !empty($projects)): ?>
                    <?php foreach ($projects as $project): ?>
                        <tr>
                            <td><?php echo htmlspecialchars($project->nama_proyek); ?></td>
                            <td><?php echo htmlspecialchars($project->client); ?></td>
                            <td><?php echo htmlspecialchars($project->tgl_mulai); ?></td>
                            <td><?php echo htmlspecialchars($project->tgl_selesai); ?></td>
                            <td><?php echo htmlspecialchars($project->pimpinan_proyek); ?></td>
                            <td><?php echo htmlspecialchars($project->keterangan); ?></td>
                            <td>
                                <a href="<?php echo base_url('main/edit_project/'.$project->id_pk); ?>" class="btn btn-edit">Edit</a>
                                <a href="<?php echo base_url('main/delete_project/' . $project->id_pk); ?>" class="btn btn-delete">Delete</a>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                <?php else: ?>
                    <tr>
                        <td colspan="7">No projects found.</td>
                    </tr>
                <?php endif; ?>
            </tbody>
        </table>
        
        <!-- Locations Table -->
        <h2>Locations</h2>
        <table>
            <thead>
                <tr>
                    <th>Location Name</th>
                    <th>Country</th>
                    <th>Province</th>
                    <th>City</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php if (isset($locations) && !empty($locations)): ?>
                    <?php foreach ($locations as $location): ?>
                        <tr>
                            <td><?php echo htmlspecialchars($location->nama_lokasi); ?></td>
                            <td><?php echo htmlspecialchars($location->negara); ?></td>
                            <td><?php echo htmlspecialchars($location->provinsi); ?></td>
                            <td><?php echo htmlspecialchars($location->kota); ?></td>
                            <td>
                                <a href="<?php echo base_url('main/edit_location/'.$location->id_pk); ?>" class="btn btn-edit">Edit</a>
                                <a href="<?php echo base_url('main/delete_location/' . $location->id_pk); ?>" class="btn btn-delete">Delete</a>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                <?php else: ?>
                    <tr>
                        <td colspan="5">No locations found.</td>
                    </tr>
                <?php endif; ?>
            </tbody>
        </table>
    </div>
</body>
</html>